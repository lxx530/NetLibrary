package com.comaiot.net.library.device.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.comaiot.net.library.device.view.TouchImageView;

import java.io.File;

public class GlideUtils {
    public static final void loadShow(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext()).load(path).into(imageView);
    }

    public static final void loadShowAsBitmap(Context context, Object path, TouchImageView imageView) {
        Glide.with(context.getApplicationContext()).asBitmap().load(path).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                imageView.setImageBitmap(resource);
                imageView.setZoom(1);
            }
        });
    }

    public static final void loadGif(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext()).asGif().load(path).into(imageView);
    }

    public static final void loadBitmap(Context context, Bitmap bitmap, ImageView imageView) {
        Glide.with(context.getApplicationContext()).asBitmap().load(bitmap).into(imageView);
    }

    public static final void loadShow(Context context, Object path, ImageView imageView, OnLoadImageResult callback) {
        Glide.with(context.getApplicationContext()).load(path).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                imageView.setImageDrawable(resource);
                callback.onSuccess();
            }

            @Override
            public void onLoadFailed(Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                callback.onError();
            }
        });
    }

    public static void loadFile(Context context, String path, ImageView imageView) {
        Glide.with(context).load(Uri.fromFile(new File(path))).into(imageView);
    }

    public static void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
        String ImageExternalCatchDir = context.getExternalCacheDir() + ExternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
        deleteFolderFile(ImageExternalCatchDir, true);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Glide.get(context).clearMemory();
                }
            });
        }
    }

    private static void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {
                    File files[] = file.listFiles();
                    for (File file1 : files) {
                        deleteFolderFile(file1.getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else {
                        if (file.listFiles().length == 0) {
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface OnLoadImageResult {
        void onSuccess();

        void onError();
    }
}
