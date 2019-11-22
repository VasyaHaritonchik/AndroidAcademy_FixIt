package com.androidacademy.fixit.utils.rxextension


import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.applySchedulers(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread(),
    unsubscribeOn: Scheduler = Schedulers.io()
): Observable<T> = this.subscribeOn(subscribeOn)
    .observeOn(observeOn)
    .unsubscribeOn(unsubscribeOn)

fun Completable.applySchedulers(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread(),
    unsubscribeOn: Scheduler = Schedulers.io()
): Completable = this.subscribeOn(subscribeOn)
    .observeOn(observeOn)
    .unsubscribeOn(unsubscribeOn)

/**
 * Используется там где необходимо выполнить Observable 1 раз и потом отписаться
 */
fun <T> Observable<T>.applySchedulersSingle(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread(),
    unsubscribeOn: Scheduler = Schedulers.io()
): Observable<T> = this.subscribeOn(subscribeOn)
    .take(1)
    .observeOn(observeOn)
    .unsubscribeOn(unsubscribeOn)

/**
 * Вызывать после в UI потоке. Т.е. после applySchedulersSingle
 */
fun <T> Observable<T>.setStartTerminateWatcher(unit: (Boolean) -> Unit): Observable<T> =
    this.doOnSubscribe { unit.invoke(true) }
        .doOnTerminate { unit.invoke(false) }
        .doOnComplete { unit.invoke(false) }

fun Completable.setStartTerminateWatcher(unit: (Boolean) -> Unit): Completable =
    this.doOnSubscribe { unit.invoke(true) }
        .doOnTerminate { unit.invoke(false) }
        .doOnComplete { unit.invoke(false) }

object RxExtension {
    fun <T> applySchedulers(): ObservableTransformer<T, T> = ObservableTransformer { it.applySchedulers() }

    fun <T> applySchedulersSingle(): ObservableTransformer<T, T> =
        ObservableTransformer{ it.applySchedulersSingle() }

    fun applySchedulersCompletable(): CompletableTransformer = CompletableTransformer { it.applySchedulers() }

}

class IgnoredException : RuntimeException()