import { put, takeEvery, all } from 'redux-saga/effects';

const delay = ms => new Promise(res => setTimeout(res, ms));

export function* testAsync() {
  yield delay(1000);
  yield put({ type: 'TEST' });
  const data = yield fetch('https://jsonplaceholder.typicode.com/todos/1');
  console.log(data);
}

export function* watchTestAsync() {
  yield takeEvery('TEST_ASYNC', testAsync);
}

export default function* rootSaga() {
  yield all([watchTestAsync()]);
}
