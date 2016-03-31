package com.alexandroukyriakos.streetbeescodechallenge.ui.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexandroukyriakos.streetbeescodechallenge.R;
import com.alexandroukyriakos.streetbeescodechallenge.UiUtil;
import com.alexandroukyriakos.streetbeescodechallenge.models.Comic;

import java.util.ArrayList;
import java.util.List;

public class ComicsAdapter extends BaseAdapter {
    private List<Comic> mComics = new ArrayList<>();
    private Context mContext;
    private ComicsAdapterUiCallback mComicsAdapterUiCallback;

    public ComicsAdapter(Context context, List<Comic> comics, ComicsAdapterUiCallback comicsAdapterUiCallback) {
        mContext = context;
        mComics = comics;
        mComicsAdapterUiCallback = comicsAdapterUiCallback;
    }

    @Override
    public int getCount() {
        return mComics.size();
    }

    @Override
    public Comic getItem(int position) {
        return mComics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_comic, null);
            viewHolder = new ViewHolder();
            bindViews(convertView, viewHolder);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Comic comic = mComics.get(position);
        setViewsValues(viewHolder, comic);

        return convertView;
    }

    private void bindViews(View convertView, ViewHolder viewHolder) {
        viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.image);
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);

        viewHolder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askToChangeThumbnailDialog();
            }
        });
    }

    public interface ComicsAdapterUiCallback {
        void askToChangeThumbnailDialogResponse(boolean success);
    }

    private void askToChangeThumbnailDialog() {
        AlertDialog dialog =
                new AlertDialog.Builder(mContext)
                        .setTitle(R.string.ask_to_change_thumbnail_title)
                        .setPositiveButton(R.string.ask_to_change_thumbnail_positive_btn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mComicsAdapterUiCallback.askToChangeThumbnailDialogResponse(true);
                            }
                        })
                        .setNegativeButton(R.string.ask_to_change_thumbnail_negative_btn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mComicsAdapterUiCallback.askToChangeThumbnailDialogResponse(false);
                            }
                        })
                        .create();
        dialog.show();
    }

    private void setViewsValues(ViewHolder viewHolder, Comic comic) {
        setComicThumbnail(comic, viewHolder);
        viewHolder.title.setText(comic.getTitle());
    }

    private void setComicThumbnail(Comic comic, ViewHolder viewHolder) {
        String thumbnailPath = comic.getThumbnail().getPath();
        String thumbnailFinalUrl = thumbnailPath + mContext.getString(R.string.dot)
                + comic.getThumbnail().getExtension();
        UiUtil.loadImageInto(
                mContext, thumbnailFinalUrl,
                R.drawable.comic_thumbnail_placeholder, viewHolder.thumbnail);
    }

    private class ViewHolder {
        ImageView thumbnail;
        TextView title;
    }
}
