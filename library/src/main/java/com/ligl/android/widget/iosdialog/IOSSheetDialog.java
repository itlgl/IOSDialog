package com.ligl.android.widget.iosdialog;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/** 
 * @author ligl
 * 
 */
public class IOSSheetDialog extends Dialog implements DialogInterface {

    public IOSSheetDialog(Context context) {
        super(context, R.style.ios_sheet_style);
    }

    public static class Builder {
        private IOSSheetDialog mIosSheetDialog;
        private Context mContext;
        private CharSequence mTitle;
        private CharSequence mCancelText;
        private SheetItem[] mItems;
        private OnClickListener mOnClickListener;
        
        public Builder(Context context) {
            this.mContext = context;
            
            this.mCancelText = mContext.getText(R.string.iossheet_cancel);
        }
        
        public Builder setTitle(CharSequence title) {
            this.mTitle = title;
            return this;
        }
        
        public Builder setTitle(int titleId) {
            this.mTitle = mContext.getText(titleId);
            return this;
        }
        
        public Builder setCancelText(CharSequence text) {
            this.mCancelText = text;
            return this;
        }
        
        public Builder setCancelText(int textId) {
            this.mCancelText = mContext.getText(textId);
            return this;
        }
        
        public Builder setData(SheetItem[] items, OnClickListener listener) {
            this.mItems = new SheetItem[items.length];
            for (int i = 0, len = items.length; i < len; i++) {
                mItems[i] = new SheetItem(items[i].name, items[i].color);
            }
            this.mOnClickListener = listener;
            return this;
        }
        
        public Builder setData(List<SheetItem> items, OnClickListener listener) {
            this.mItems = new SheetItem[items.size()];
            for (int i = 0, len = items.size(); i < len; i++) {
                SheetItem item = items.get(i);
                mItems[i] = new SheetItem(item.name, item.color);
            }
            this.mOnClickListener = listener;
            return this;
        }
        
        public IOSSheetDialog create() {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View sheetView = inflater.inflate(R.layout.ios_sheet_dialog, null);
            mIosSheetDialog = new IOSSheetDialog(mContext);
            
            TextView tvTitle = (TextView) sheetView.findViewById(R.id.title);
            LinearLayout message_layout = (LinearLayout) sheetView.findViewById(R.id.message_layout);
            Button btn_cancel = (Button) sheetView.findViewById(R.id.btn_cancel);
            
            // 设置标题
            tvTitle.setText(mTitle);
            // 填充列表内容
            for (int i = 0, len = mItems.length; i < len; i++) {
                
                View itemView = inflater.inflate(R.layout.ios_sheet_item, message_layout, false);
                Button btnItem = (Button) itemView.findViewById(R.id.btn_item);
                btnItem.setText(mItems[i].name);
                btnItem.setTextColor(mItems[i].color);
                if(i == mItems.length - 1) {
                    btnItem.setBackgroundResource(R.drawable.iossheet_bottom_btn_selector);
                }
                final int itemIndex = i;
                btnItem.setOnClickListener(new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        if(mOnClickListener != null) {
                            mOnClickListener.onClick(mIosSheetDialog, itemIndex);
                        }
                        mIosSheetDialog.dismiss();
                    }
                });
                message_layout.addView(itemView);
            }
            btn_cancel.setText(mCancelText);
            // 设置取消事件
            btn_cancel.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    mIosSheetDialog.dismiss();
                }
            });
            
            // 获取屏幕高度
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics metrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(metrics);
            // 设置宽度全屏，底部弹出
            Window window = mIosSheetDialog.getWindow();
            window.setWindowAnimations(R.style.ios_sheet_anim);
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams wml = window.getAttributes();
            wml.width = metrics.widthPixels;
            wml.gravity = Gravity.BOTTOM;
            wml.y = 0;
            window.setAttributes(wml);
            sheetView.setMinimumWidth(metrics.widthPixels);
            
            // 设置dialog的高度不能超过屏幕的0.7
            LayoutParams vgl = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT);
            int maxHeight = (int) (metrics.heightPixels * 0.7);
            // 测量dialog的高度
            sheetView.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            int dialogMeasureHeight = sheetView.getMeasuredHeight();
            if(dialogMeasureHeight > maxHeight) {
                vgl.height = maxHeight;
            }
            mIosSheetDialog.setContentView(sheetView, vgl);
            return mIosSheetDialog;
        }
        
        public IOSSheetDialog show() {
            mIosSheetDialog = create();
            mIosSheetDialog.show();
            return mIosSheetDialog;
        } 
    }
    
    public static final class SheetItem {
        public static final int RED = Color.parseColor("#FFFD4A2E");
        public static final int BLUE = Color.parseColor("#FF037BFF");
        //public static final int GREY = Color.parseColor("#FFFD4A2E");
        
        public String name;
        public int color;
        
        public SheetItem() {
        }
        
        public SheetItem(String name, int color) {
            this.name = name;
            this.color = color;
        }
        
    }
}
