package conts;

public interface NotificationPageVariables {
    public static final String APP_MENU = "//android.widget.TextView[contains(@text, 'App')]";//xpath
    public static final String NOTIFICATION_MENU = "//android.widget.TextView[contains(@text, 'Notification')]";//xpath
    public static final String INCOMING_MESSAGE ="//android.widget.TextView[contains(@text, 'IncomingMessage')]"; //xpath
    public static final String SHOW_NOTIFICATION_BTN ="com.hmh.api:id/notify";//id
    public static final String APP_NOTIFICATION_APP_NAME_TEXT ="//android.widget.TextView[contains(@text, 'API Demos')]";//xpath
    public static final String APP_NOTIFICATION_TITLE="//android.widget.TextView[contains(@text, 'Joe')]";//xpath
    public static final String APP_NOTIFICATION_TEXT="//android.widget.TextView[contains(@text, 'kthx. meet u for dinner. cul8r')]";//xpath
    public static final String APP_NOTIFICATION_SCREEN="//android.widget.TextView[contains(@text, 'App/Notification/IncomingMessageView')]";//xpath
    public static final String APP_NOTIFICATION_SCREEN_MESSAGE="//android.widget.TextView[contains(@text, 'kthx. meet u for dinner. cul8r')]";//xpath
    public static final String CLOSE_NOTIFICATIONS="com.android.systemui:id/notification_stack_scroller";//id

}

