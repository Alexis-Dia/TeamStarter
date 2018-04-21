import golos from 'golos-js'

export function fetchGolosBlog (data) {
  //const resultData = golos.api.getBlogAsync('alexeyd', 5, 5);
  console.log('data = ',data)
  const resultData = golos.api.getBlogAsync(data.data.author, data.data.enterId, data.data.limit);
  //resultData.then(result => console.log(result));
  //resultData.then(result => { return result });
  console.log('res data = ', resultData)
  return resultData;
}
