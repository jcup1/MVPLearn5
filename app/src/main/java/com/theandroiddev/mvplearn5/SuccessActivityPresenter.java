package com.theandroiddev.mvplearn5;

import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by grazyna on 2017-10-29.
 */

class SuccessActivityPresenter {
    private SuccessActivityView view;
    private SuccessRepository successRepository;

    public SuccessActivityPresenter(SuccessActivityView view, SuccessRepository successRepository) {
        this.view = view;
        this.successRepository = successRepository;
    }

    public void loadSuccesses() {
        List<Success> successList = successRepository.getSuccesses();

        if(successList.isEmpty()) {
            view.displayNoSuccesses();
        }
        else {
            view.displaySuccesses(successList);
        }
    }

}
