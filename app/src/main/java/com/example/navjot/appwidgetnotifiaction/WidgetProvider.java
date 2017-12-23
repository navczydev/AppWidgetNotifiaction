package com.example.navjot.appwidgetnotifiaction;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by Navjot on 12/22/2017.
 */

public class WidgetProvider extends AppWidgetProvider {
    /**
     * Called in response to the {@link AppWidgetManager#ACTION_APPWIDGET_UPDATE} and
     * {@link AppWidgetManager#ACTION_APPWIDGET_RESTORED} broadcasts when this AppWidget
     * provider is being asked to provide {@link RemoteViews RemoteViews}
     * for a set of AppWidgets.  Override this method to implement your own AppWidget functionality.
     * <p>
     * {@more}
     *
     * @param context          The {@link Context Context} in which this receiver is
     *                         running.
     * @param appWidgetManager A {@link AppWidgetManager} object you can call {@link
     *                         AppWidgetManager#updateAppWidget} on.
     * @param appWidgetIds     The appWidgetIds for which an update is needed.  Note that this
     *                         may be all of the AppWidget instances for this provider, or just
     *                         a subset of them.
     * @see AppWidgetManager#ACTION_APPWIDGET_UPDATE
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        ComponentName componentName = new ComponentName(context,WidgetProvider.class);
        int[] allIds = appWidgetManager.getAppWidgetIds(componentName);
        for(int widgetId : allIds)
        {
            int randomNumber = (new Random().nextInt(100));
            Log.w(getClass().getSimpleName(),String.valueOf(randomNumber));
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget);
            //remoteViews.setTextViewText(R.id.updateWidget,String.valueOf(randomNumber));
           // Intent intent = new Intent(context,WidgetProvider.class);
            Intent intent = new Intent(context,MainActivity.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,allIds);
            //PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            remoteViews.setOnClickPendingIntent(R.id.updateWidget,pendingIntent);
            appWidgetManager.updateAppWidget(widgetId,remoteViews);
        }
    }
}
