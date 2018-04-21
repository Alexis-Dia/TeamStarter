import { apiCall } from '../../services/api'

export function fetchAuth (ob) {
    return apiCall(`http://localhost:8080/auth`, 'POST', ob)
}
