import { fork } from 'redux-saga/effects'

import { mapFetch, mapSeed, mapDeletePoint, mapGridFetch } from '../api/map/mapSagas'
import { loginAuthFetch } from '../api/login/loginSagas'
import { signupFetch, ifUserExistFetch } from '../api/signup/signupSagas'
import { fetchBlog } from "../api/golosData/golosDataSagas";

// Your sagas for this container

export default function * rootSaga () {
  yield [
    fork(mapFetch),
    fork(mapSeed),
    fork(mapDeletePoint),
    fork(fetchBlog),    //-- for fetching grid data from api
    fork(loginAuthFetch),
    fork(signupFetch),
    fork(ifUserExistFetch)
  ]
}
