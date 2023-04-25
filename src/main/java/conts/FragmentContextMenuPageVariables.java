package conts;

public interface FragmentContextMenuPageVariables {
    public static final String APP_MENU = "//android.widget.TextView[contains(@text, 'App')]";//xpath
    public static final String FRAGMENT_MENU = "//android.widget.TextView[contains(@text, 'Fragment')]";//xpath
    public static final String CONTEXT_MENU ="//android.widget.TextView[contains(@text, 'Context Menu')]"; //xpath
    public static final String LONG_PRESS_BTN ="com.hmh.api:id/long_press";//id
    public static final String LONG_PRESS_MENU_A ="//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView";//xpath
    public static final String LONG_PRESS_MENU_B ="//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";//xpath
}

