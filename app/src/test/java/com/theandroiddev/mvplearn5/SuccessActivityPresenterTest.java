package com.theandroiddev.mvplearn5;

import junit.framework.Assert;

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
        //given
//        SuccessActivityView view = new MockView();
//        SuccessRepository successRepository = new MockSuccessRepository(false);
        Mockito.when(successRepository.getSuccesses()).thenReturn(Collections.EMPTY_LIST);
        //when
        SuccessActivityPresenter presenter = new SuccessActivityPresenter(view, successRepository);
        presenter.loadSuccesses();
        //then
//        Assert.assertEquals(true, ((MockView)view).noSuccessesPassed);
        Mockito.verify(view).displayNoSuccesses();
    }

    @Test
    public void shouldShowSuccesses() {
        //given
//        SuccessActivityView view = new MockView();
//        SuccessRepository successRepository = new MockSuccessRepository(true);
        List<Success> successList = Arrays.asList(new Success(), new Success());
        Mockito.when(successRepository.getSuccesses()).thenReturn(successList);
        //when
        SuccessActivityPresenter presenter = new SuccessActivityPresenter(view, successRepository);
        presenter.loadSuccesses();
        Mockito.verify(view).displaySuccesses(successList);
        //then
//        Assert.assertEquals(true, ((MockView)view).successesPassed);
    }

//    public class MockView implements SuccessActivityView {
//
//        public boolean noSuccessesPassed;
//        public boolean successesPassed;
//
//        @Override
//        public void displaySuccesses(List<Success> successList) {
//            if(successList.size() ==2){
//                successesPassed = true;
//            }
//        }
//
//        @Override
//        public void displayNoSuccesses(List<Success> successList) {
//                noSuccessesPassed = true;
//
//        }
//    }
//
//    public class MockSuccessRepository implements SuccessRepository {
//
//        private boolean returnSomeSuccesses;
//
//        public MockSuccessRepository(boolean returnSomeSuccesses){
//
//            this.returnSomeSuccesses = returnSomeSuccesses;
//        }
//
//        @Override
//        public List<Success> getSuccesses() {
//            if(returnSomeSuccesses) {
//                return Arrays.asList(new Success(), new Success());
//            } else {
//                return Collections.emptyList();
//            }
//        }
//    }


}