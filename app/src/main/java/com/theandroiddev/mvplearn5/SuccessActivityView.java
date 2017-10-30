package com.theandroiddev.mvplearn5;

import java.util.List;

/**
 * Created by grazyna on 2017-10-29.
 */

interface SuccessActivityView {

    public void displaySuccesses(List<Success> successList);

    public void displayNoSuccesses();
}
