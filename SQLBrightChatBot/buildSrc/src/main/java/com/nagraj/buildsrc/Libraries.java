package com.nagraj.buildsrc;

public class Libraries {

    private static final String SUPPORT_LIB_VERSION = "28.0.0";
    private static final String RETROFIT_VERSION = "2.3.0";
    private static final String OKHTTP_VERSION = "3.9.0";
    private static final String DAGGER_VERSION = "2.10";
    private static final String BUTTERKNIFE_VERSION = "9.0.0";
    private static final String AUTOVALUE_VERSION = "1.6";
    private static final String RXJAVA_VERSION = "1.3.5";
    private static final String RXANDROID_VERSION = "1.2.1";
    private static final String SQLBRITE_VERSION = "1.1.2";

    // GROUP IDS //
    private static final String SUPPORT = "com.android.support:";
    private static final String RETROFIT_ID = "com.squareup.retrofit2:";
    private static final String OKHTTP_ID = "com.squareup.okhttp3:";

    // SUPPORT LIBS
    public static final String APP_COMPAT = SUPPORT + "appcompat-v7:" + SUPPORT_LIB_VERSION;
    public static final String DESIGN = SUPPORT + "design:" + SUPPORT_LIB_VERSION;
    public static final String RECYCLER_VIEW = SUPPORT + "recyclerview-v7:" + SUPPORT_LIB_VERSION;
    public static final String CARD_VIEW = SUPPORT + "cardview-v7:" + SUPPORT_LIB_VERSION;
    public static final String SUPPORT_ANNOTATION =
            SUPPORT + "support-annotations:" + SUPPORT_LIB_VERSION;
    public static final String GRID_LAYOUT = SUPPORT + "gridlayout-v7:" + SUPPORT_LIB_VERSION;
    public static final String MULTI_DEX = SUPPORT + "multidex:1.0.3";

    // GOOGLE PLAY SERVICES AND FIREBASE
    private static final String PLAY_SERVICES = "com.google.android.gms:";
    public static final String PLAY_SERVICES_MAPS =
            PLAY_SERVICES + "play-services-maps:16.1.0";
    public static final String PLAY_SERVICES_LOCATION =
            PLAY_SERVICES + "play-services-location:16.0.0";

    public static final String FIRE_BASE_CORE = "com.google.firebase:firebase-core:16.0.1";

    public static final String GOOGLE_MAP_UTILS = "com.google.maps.android:android-maps-utils:0.5";

    // CODE GEN
    public static final String BUTTER_KNIFE = "com.jakewharton:butterknife:" + BUTTERKNIFE_VERSION;
    public static final String BUTTER_KNIFE_COMPILER =
            "com.jakewharton:butterknife-compiler:" + BUTTERKNIFE_VERSION;
    public static final String DAGGER = "com.google.dagger:dagger:" + DAGGER_VERSION;
    public static final String DAGGER_COMPILER =
            "com.google.dagger:dagger-compiler:" + DAGGER_VERSION;
    public static final String AUTOVALUE_ANNOTATIONS =
            "com.google.auto.value:auto-value-annotations:" + AUTOVALUE_VERSION;
    public static final String AUTOVALUE_COMPILER =
            "com.google.auto.value:auto-value:" + AUTOVALUE_VERSION;
    public static final String AUTOVALUE_CURSOR_COMPILER =
            "com.gabrielittner.auto.value:auto-value-cursor:1.1.0";
    public static final String AUTOVALUE_CURSOR =
            "com.gabrielittner.auto.value:auto-value-cursor-annotations:1.1.0";
    public static final String AUTOVALUE_PARCEL_COMPILER =
            "com.ryanharter.auto.value:auto-value-parcel:0.2.5";
    public static final String AUTOVALUE_WITH_COMPILER =
            "com.gabrielittner.auto.value:auto-value-with:1.0.0";
    public static final String ANDROID_STATE = "com.evernote:android-state:1.3.1";
    public static final String ANDROID_STATE_PROCESSOR = "com.evernote:android-state-processor:1.3.1";

    // FUNCTIONAL
    public static final String RX_JAVA = "io.reactivex:rxjava:" + RXJAVA_VERSION;
    public static final String RX_ANDROID = "io.reactivex:rxandroid:" + RXANDROID_VERSION;
    public static final String STREAMS = "com.annimon:stream:1.2.1";

    // NETWORKING & STORAGE
    public static final String AWS_KINESIS = "com.amazonaws:aws-android-sdk-kinesis:2.4.2";
    public static final String RETROFIT = RETROFIT_ID + "retrofit:" + RETROFIT_VERSION;
    public static final String RETROFIT_CONVERTER =
            RETROFIT_ID + "converter-gson:" + RETROFIT_VERSION;
    public static final String RETROFIT_ADAPTER = RETROFIT_ID + "adapter-rxjava:" + RETROFIT_VERSION;
    public static final String OKHTTP = OKHTTP_ID + "okhttp:" + OKHTTP_VERSION;
    public static final String OKHTTP_LOGGER = OKHTTP_ID + "logging-interceptor:" + OKHTTP_VERSION;
    public static final String SQLBRITE = "com.squareup.sqlbrite:sqlbrite:" + SQLBRITE_VERSION;
    public static final String AWS_S3_STORAGE = "com.amazonaws:aws-android-sdk-s3:2.6.+";
    public static final String AWS_SDK_CORE = "com.amazonaws:aws-android-sdk-core:2.6.+";
    public static final String AWS_SDK_COGNITO = "com.amazonaws:aws-android-sdk-cognito:2.6.+";
    public static final String AWS_MOBILE_CLIENT =
            "com.amazonaws:aws-android-sdk-mobile-client:2.6.+@aar";
    public static final String AWS_COGNITO_AUTH =
            "com.amazonaws:aws-android-sdk-cognitoauth:2.6.+@aar";
    public static final String AWS_MOBILE_AUTH_CORE =
            "com.amazonaws:aws-android-sdk-auth-core:2.6.+@aar";
    public static final String AWS_AUTH_USER_POOL =
            "com.amazonaws:aws-android-sdk-auth-userpools:2.6.+@aar";

    public static final String GSON = "com.google.code.gson:gson:2.8.5";

    // UI
    public static final String GLIDE = "com.github.bumptech.glide:glide:3.7.0";
    public static final String CALLIGRAPHY = "uk.co.chrisjenx:calligraphy:2.2.0";
    public static final String CONSTRAINT_LAYOUT =
            "com.android.support.constraint:constraint-layout:1.0.2";
    public static final String HORIZONTAL_PROGRESS =
            "me.zhanghai.android.materialprogressbar:library:1.4.1";
    public static final String CIRCULAR_PROGRESS =
            "com.github.castorflex.smoothprogressbar:library-circular:1.2.0";
    public static final String MULTI_STATE_VIEW = "com.github.Kennyc1012:MultiStateView:1.3.2";
    public static final String MULTI_VIEW_ADAPTER = "com.github.devahamed:multi-view-adapter:1.3.0";
    public static final String MATERIAL_DIALOGS = "com.afollestad.material-dialogs:core:0.9.0.2";
    public static final String MATERIAL_CALENDAR_VIEW =
            "com.github.prolificinteractive:material-calendarview:2.0.1";
    public static final String MATERIAL_DATE_TIME_PICKER =
            "com.wdullaer:materialdatetimepicker:3.6.4";
    public static final String PAGE_INDICATOR = "com.romandanylyk:pageindicatorview:0.1.1";
    public static final String PULSATOR = "pl.bclogic:pulsator4droid:1.0.3";
    public static final String EVERNOTE_JOBS = "com.evernote:android-job:1.2.1";
    public static final String ROUND_CORNER_PROGRESS = "com.akexorcist:RoundCornerProgressBar:2.0.3";
    public static final String GLIDE_IMAGE_TRANSFORMATION = "jp.wasabeef:glide-transformations:3.1.1";
    public static final String PROGRESS_LODING = "com.victor:lib:1.0.4";
    // MISC
    public static final String IMAGE_COMPRESSOR = "id.zelory:compressor:2.1.0";
    public static final String ZXING_BARCODE_SCANNER = "com.journeyapps:zxing-android-embedded:3.6.0";
    // LOGGING
    public static final String TIMBER = "com.jakewharton.timber:timber:4.7.1";
    public static final String CRASHLYTICS = "com.crashlytics.sdk.android:crashlytics:2.10.1@aar";

    // TESTING
    public static final String JUNIT = "junit:junit:4.12";
    public static final String MOCKITO = "org.mockito:mockito-core:1.10.5";
    public static final String ESPRESSO = "com.android.support.test.espresso:espresso-core:2.2.2";
    public static final String DEBUG_DB = "com.amitshekhar.android:debug-db:1.0.1";

    //Added By Me
    public static final String RECYCLER_X = "androidx.recyclerview:recyclerview:1.1.0";
    public static final String RX_ANDROID_2 = "io.reactivex.rxjava2:rxandroid:2.1.1";

    public static final String RX_ANDROID_3="io.reactivex.rxjava3:rxandroid:3.0.0";
    public static final String RX_JAVA_3="io.reactivex.rxjava3:rxjava:3.0.0";


}
