package com.theandroiddev.mvplearn5;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by grazyna on 2017-10-29.
 */
public class SuccessActivityPresenterTest {

    private final List<Success> successList = Arrays.asList(new Success(), new Success());
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    SuccessRepository successRepository;
    @Mock
    SuccessActivityView view;
    SuccessActivityPresenter presenter;

    @Before
    public void setUp() {
        presenter = new SuccessActivityPresenter(view, successRepository);
    }

    @Test
    public void shouldShowNoSuccesses() {

        when(successRepository.getSuccesses()).thenReturn(EMPTY_LIST);

        presenter.loadSuccesses();

        verify(view).displayNoSuccesses();
    }

    @Test
    public void shouldShowSuccesses() {
        when(successRepository.getSuccesses()).thenReturn(successList);

        presenter.loadSuccesses();

        verify(view).displaySuccesses(successList);
    }

}