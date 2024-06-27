package com.jo;

import java.util.LinkedList;
import java.util.List;
import static java.util.concurrent.Flow.Subscription;
import static java.util.concurrent.Flow.Subscriber;
//https://www.baeldung.com/java-9-reactive-streams
class EndSubscriber<T> implements Subscriber<T> {
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}

public class ReactiveStreamsTest {

}
