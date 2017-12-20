package com.ysr;


import rx.Observable;
import rx.Subscriber;

public class Main {

    public static void main(String[] args) {
        //创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("call");
                subscriber.onCompleted();
//                throw new NullPointerException();
            }
        });
        //创建观察者
        /**
         * onCompleted he onError 单联
         */
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String o) {
                System.out.println("onNext>>"+o);
            }
        };
        //订阅
        observable.subscribe(subscriber);
    }
}
