package com.cameramanager.restdemo.cameradetail;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.service.CMService;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailFragment extends Fragment implements CameraDetailContract.View {

    private static final String ARGUMENT_CAMERA_ID = "camera_id";
    @NonNull
    private CameraDetailContract.Presenter mPresenter;

    private CollapsingToolbarLayout mCollapsingToolbar;
    private ImageView mSnapshotImage;
    private VideoView mStreamVideo;
    private MediaController mMediaController;


    @Override
    public void setPresenter(@NonNull CameraDetailContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    public static CameraDetailFragment newInstance(final Long cameraId) {
        final Bundle arguments = new Bundle();
        arguments.putLong(ARGUMENT_CAMERA_ID, cameraId);
        CameraDetailFragment fragment = new CameraDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cameradetail, container, false);
        setHasOptionsMenu(true);
        mCollapsingToolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        mSnapshotImage = (ImageView)getActivity().findViewById(R.id.snapshot_imageview);
        mStreamVideo = (VideoView) root.findViewById(R.id.camera_video_stream);
        mMediaController = new MediaController(getContext());

        mStreamVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
                return true;
            }
        });
        mStreamVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mediaPlayer) {
                mMediaController.show(0);
            }
        });
        return root;
    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void showName(final String name) {
        mCollapsingToolbar.setTitle(name);
    }

    @Override
    public void showMissingCamera() {

    }

    @Override
    public void setLoadingIndicator(final boolean active) {

    }

    @Override
    public void showScreencap(Long cameraId) {
        checkNotNull(cameraId);
        Picasso.with(getContext()).load(CMService.buildSnapshotUrl(cameraId)).into(mSnapshotImage);
    }

    @Override
    public void loadVideo(final CameraStream cameraStream) {
        final List<String> urls = cameraStream.getUrls();
        if (urls == null | urls.size() < 1) {
            return;
        }
        final String s = urls.get(0);
        final Uri parse = Uri.parse(s);
        mStreamVideo.setVideoURI(parse);
    }

    @Override
    public void play() {
        if(!mStreamVideo.isPlaying()) {
            mStreamVideo.start();
        }
    }

    @Override
    public void stop() {
        if(mStreamVideo.isPlaying()) {
            mStreamVideo.stopPlayback();
        }
    }

    @Override
    public void setVideoLoadingIndicator(final boolean active) {

    }
}
