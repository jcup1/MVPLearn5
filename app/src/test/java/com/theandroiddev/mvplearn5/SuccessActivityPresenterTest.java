package com.theandroiddev.mvplearn5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by grazyna on 2017-10-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class SuccessActivityPresenterTest {

    @Mock
    SuccessRepository successRepository;
    @Mock
    SuccessActivityView view;

    @Test
    public void shouldShowNoSuccesses() {

        Mockito.when(successRepository.getSuccesses()).thenReturn(Collections.EMPTY_LIST);
        SuccessActivityPresenter presenter = new SuccessActivityPresenter(view, successRepository);
        presenter.loadSuccesses();
        Mockito.verify(view).displayNoSuccesses();
    }

    @Test
    public void shouldShowSuccesses() {
        List<Success> successList = Arrays.asList(new Success(), new Success());
        Mockito.when(successRepository.getSuccesses()).thenReturn(successList);
        SuccessActivityPresenter presenter = new SuccessActivityPresenter(view, successRepository);
        presenter.loadSuccesses();
        Mockito.verify(view).displaySuccesses(successList);

    }

}