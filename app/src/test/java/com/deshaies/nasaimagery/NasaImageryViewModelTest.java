package com.deshaies.nasaimagery;

import android.app.Application;
import com.deshaies.nasaimagery.model.NasaResult;
import com.deshaies.nasaimagery.network.NasaService;
import com.deshaies.nasaimagery.viewmodel.NasaImageryViewModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.TestSubscriber;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class NasaImageryViewModelTest {

    @Mock
    public NasaService nasaService;

    private NasaImageryViewModel purchaseViewModel;
    private TestSubscriber<Boolean> testSubscriber;
    private Application context;

    @Before
    public void setUpViewModel() {
        // Mock purchase api
        context = Mockito.mock(Application.class);
        nasaService = Mockito.mock(NasaService.class);
        purchaseViewModel = new NasaImageryViewModel(context);
        testSubscriber = TestSubscriber.create();
    }

    @BeforeClass
    public static void setUpRxSchedulers() {
        Scheduler immediate = new Scheduler() {
            @Override
            public Disposable scheduleDirect(@NonNull Runnable run, long delay, @NonNull TimeUnit unit) {
                // this prevents StackOverflowErrors when scheduling with a delay
                return super.scheduleDirect(run, 0, unit);
            }

            @Override
            public ExecutorScheduler.ExecutorWorker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run, false);
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);
    }

    @Test
    public void testGetImageryResultRx() throws Exception {
        NasaResult result = new NasaResult();
        when(nasaService.getNasaImageryResultRx(anyString(), anyString(), anyString())).thenReturn(Observable.just(result));
        purchaseViewModel.getNasaImageryResultRx(anyString(), anyString());
        testSubscriber.assertNoErrors();
    }
}