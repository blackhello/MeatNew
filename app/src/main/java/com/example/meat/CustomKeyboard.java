package com.example.meat;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.content.Context;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by 王刚 on 2017/12/27.
 */

class CustomKeyboard {
    /** A link to the KeyboardView that is used to render this CustomKeyboard. */
    private KeyboardView mKeyboardView;
    private LinearLayout mlinearLayout;
    /** A link to the activity that hosts the {@link #mKeyboardView}. */
    private Activity mHostActivity;

    private  Keyboard mKeyboder;

    private  Keyboard mKeyboderFalse;

    /** The key (code) handler. */
    private OnKeyboardActionListener mOnKeyboardActionListener = new OnKeyboardActionListener()
    {

        public final static int CodeDelete =Keyboard.KEYCODE_DELETE; //-5; // Keyboard.KEYCODE_DELETE
        public final static int CodeDone =Keyboard.KEYCODE_DONE;// -4; // Keyboard.KEYCODE_CANCEL
       //public final static int CodeClear =Keyboard.KEY //-5; // Keyboard.KEYCODE_Clear

        @Override
        public void onKey(int primaryCode, int[] keyCodes)
        {
            // NOTE We can say '<Key android:codes="49,50" ... >' in the xml
            // file; all codes come in keyCodes, the first in this list in
            // primaryCode
            // Get the EditText and its Editable
            View focusCurrent = mHostActivity.getWindow().getCurrentFocus();

            //ShowAlert(String.valueOf(focusCurrent.getClass() != EditText.class),mHostActivity);
           // if (focusCurrent == null || focusCurrent.getClass() != EditText.class){
           //     return;}
            if(focusCurrent==null){return;}
            EditText edittext = (EditText) focusCurrent;
            Editable editable = edittext.getText();
            int start = edittext.getSelectionStart();
            //ShowAlert(Character.toString((char) primaryCode),mHostActivity);


            // Apply the key to the edittext
            if (primaryCode == CodeDone)
            {
                hideCustomKeyboard();
            }
            else if (primaryCode == CodeDelete)
            {
                if (editable != null && start > 0)
                    editable.delete(start - 1, start);
            }
            //else if (primaryCode == CodeClear)
            //{
            //    if (editable != null && start > 0)
            //        editable.clear();
            //}
            else
            { // insert character

                //ShowAlert(String.valueOf(focusCurrent == null),mHostActivity);
                editable.insert(start, Character.toString((char) primaryCode));
            }
        }
        private void ShowAlert(String s, Activity activity){
            AlertDialog dialog=new AlertDialog.Builder(activity).create();
            dialog.setMessage(s);
            dialog.show();
            WindowManager.LayoutParams params=dialog.getWindow().getAttributes();
            params.width=300;
            params.height=200;
            dialog.getWindow().setAttributes(params);
        }
        @Override
        public void onPress(int arg0)
        {
        }

        @Override
        public void onRelease(int primaryCode)
        {
        }

        @Override
        public void onText(CharSequence text)
        {
        }

        @Override
        public void swipeDown()
        {
        }

        @Override
        public void swipeLeft()
        {
        }

        @Override
        public void swipeRight()
        {
        }

        @Override
        public void swipeUp()
        {
        }
    };

    /**
     * Create a custom keyboard, that uses the KeyboardView (with resource id
     * <var>viewid</var>) of the <var>host</var> activity, and load the keyboard
     * layout from xml file <var>layoutid</var> (see {@link Keyboard} for
     * description). Note that the <var>host</var> activity must have a
     * <var>KeyboardView</var> in its layout (typically aligned with the bottom
     * of the activity). Note that the keyboard layout xml file may include key
     * codes for navigation; see the constants in this class for their values.
     * Note that to enable EditText's to use this custom keyboard, call the
     * {@link #registerEditText(int)}.
     *
     * @param activity
     *            The hosting activity.
     * @param viewid
     *            The id of the KeyboardView.
     * @param layoutid
     *            The id of the xml file containing the keyboard layout.
     */
    //public CustomKeyboard(Activity activity, int viewid, int layoutid)
    public CustomKeyboard(Activity activity, int viewid,int layoutid)
    {
        mHostActivity = activity;
        mKeyboardView = (KeyboardView) mHostActivity.findViewById(viewid);
        mlinearLayout=(LinearLayout) mHostActivity.findViewById(layoutid) ;
/*        mKeyboder=new Keyboard(mHostActivity, layoutid);
        mKeyboderFalse=new Keyboard(mHostActivity, layoutid);*/
        mKeyboder=new Keyboard(mHostActivity, R.xml.keyboard);
        mKeyboderFalse=new Keyboard(mHostActivity, R.xml.keyboard);
        //mKeyboardView.setKeyboard(mKeyboder);
        mKeyboardView.setPreviewEnabled(false); // NOTE Do not show the preview
        // balloons
        mKeyboardView.setOnKeyboardActionListener(mOnKeyboardActionListener);
        // Hide the standard keyboard initially
        mHostActivity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /** Returns whether the CustomKeyboard is visible. */
    public boolean isCustomKeyboardVisible()
    {
        return mKeyboardView.getVisibility() == View.VISIBLE;
    }
    private boolean isNumber(String str) {
        String wordstr = "0123456789";
        return wordstr.contains(str);
    }
    /**
     * Make the CustomKeyboard visible, and hide the system keyboard for view v.
     */
    public void showCustomKeyboard(View v, boolean iRandom)
    {
        //mKeyboardView.setVisibility(View.VISIBLE);
        //mKeyboardView.setEnabled(true);
        //if (v != null)
        //    ((InputMethodManager) mHostActivity
        //            .getSystemService(Activity.INPUT_METHOD_SERVICE))
        //            .hideSoftInputFromWindow(v.getWindowToken(), 0);
        if (iRandom==true){
            List<Keyboard.Key> keys = mKeyboder.getKeys();
            List<Keyboard.Key> newkeyList = new ArrayList<Keyboard.Key>();
            for (Keyboard.Key key : keys) {
                if (key.label!=null && isNumber(key.label.toString())) {
                    newkeyList.add(key);
                }
            }

            int count = newkeyList.size();
            LinkedList<KeyModel> temp=new LinkedList<KeyModel>();
            for (int i = 0; i < count; i++) {
                temp.add(new KeyModel(48 + i, i + ""));
            }

            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(count - i);
                KeyModel keyModel = temp.get(index);
                newkeyList.get(i).label=keyModel.getLable();
                newkeyList.get(i).codes[0]=keyModel.getCode();
                temp.remove(index);
            }
            mKeyboardView.setKeyboard(mKeyboder);
        }else {

            mKeyboardView.setKeyboard(mKeyboderFalse);
            //mKeyboardView.setKeyboard(mKeyboder);
        }

        mKeyboardView.setEnabled(true);
        mKeyboardView.setVisibility(View.VISIBLE);
        mlinearLayout.setVisibility(View.VISIBLE);


        // mKeyboardView.setVisibility(View.VISIBLE);
        // mKeyboardView.setEnabled(true);
        if (v != null)
            ((InputMethodManager) mHostActivity
                    .getSystemService(Activity.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(v.getWindowToken(), 0);



    }

    /** Make the CustomKeyboard invisible. */
    public void hideCustomKeyboard()
    {
        mKeyboardView.setVisibility(View.GONE);
        mlinearLayout.setVisibility(View.GONE);
        mKeyboardView.setEnabled(false);
    }

    /**
     * Register <var>EditText<var> with resource id <var>resid</var> (on the
     * hosting activity) for using this custom keyboard.
     *
     * @param resid
     *            The resource id of the EditText that registers to the custom
     *            keyboard.
     */
    public void registerEditText(int resid, final boolean iRandom)
    {
        // Find the EditText 'resid'
        EditText edittext = (EditText) mHostActivity.findViewById(resid);
        // Make the custom keyboard appear
        edittext.setOnFocusChangeListener(new OnFocusChangeListener()
        {
            // NOTE By setting the on focus listener, we can show the custom
            // keyboard when the edit box gets focus, but also hide it when the
            // edit box loses focus
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (hasFocus)
                    showCustomKeyboard(v,iRandom);
                else
                    hideCustomKeyboard();
            }
        });
        edittext.setOnClickListener(new OnClickListener()
        {
            // NOTE By setting the on click listener, we can show the custom
            // keyboard again, by tapping on an edit box that already had focus
            // (but that had the keyboard hidden).
            @Override
            public void onClick(View v)
            {
                showCustomKeyboard(v,iRandom);
            }
        });
        // Disable standard keyboard hard way
        // NOTE There is also an easy way:
        // 'edittext.setInputType(InputType.TYPE_NULL)' (but you will not have a
        // cursor, and no 'edittext.setCursorVisible(true)' doesn't work )
        edittext.setOnTouchListener(new OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                EditText edittext = (EditText) v;
                int inType = edittext.getInputType(); // Backup the input type
                edittext.setInputType(InputType.TYPE_NULL); // Disable standard
                // keyboard
                edittext.setText("");
                edittext.onTouchEvent(event); // Call native handler
                edittext.setInputType(inType); // Restore input type
                edittext.setSelection(edittext.length());
                edittext.requestFocus();

                return true; // Consume touch event
            }
        });
        // Disable spell check (hex strings look like words to Android)
        edittext.setInputType(edittext.getInputType()
                | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

}
