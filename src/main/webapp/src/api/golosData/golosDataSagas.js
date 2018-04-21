import { takeEvery, call, put } from 'redux-saga/effects'
import {fetchGolosBlog} from "./golosDataApi";
import { showLoading, hideLoading } from 'react-redux-loading-bar'

export function fetchGolosBlogApi (data) {
  console.log('ddd: ', data)
  return fetchGolosBlog(data)
    .then(data => {
      return { response: data }
    })
    .catch(err => {
      return err
    })
}

export function * tryFetchGolosBlogApi (data) {
  try {
    yield put(showLoading())
    const { response, error } = yield call(fetchGolosBlogApi, data)
    console.log('res: ', response)
    console.log('err: ', error)
    if (response) {
      yield put({ type: 'MAP_FETCH_GOLOS_BLOG_SUCCESS', response })
    } else {
      yield put({ type: 'MAP_FETCH_GOLOS_BLOG_FAILURE', error })
    }
  } finally {
    yield put(hideLoading())
  }
}

export function * fetchBlog () {
  console.log('3')
  yield takeEvery('MAP_FETCH_GOLOS_BLOG', tryFetchGolosBlogApi)
}
