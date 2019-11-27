import { put, takeEvery, all } from 'redux-saga/effects';

const delay = ms => new Promise(res => setTimeout(res, ms));

export function* testAsync() {
  yield delay(1000);
  const data = yield fetch('https://randomuser.me/api/');
  const parsedDate = yield data.json();
  yield put({ type: 'TEST', payload: parsedDate.info.seed });
}

export function* watchTestAsync() {
  yield takeEvery('TEST_ASYNC', testAsync);
}

export default function* rootSaga() {
  yield all([watchTestAsync()]);
}
