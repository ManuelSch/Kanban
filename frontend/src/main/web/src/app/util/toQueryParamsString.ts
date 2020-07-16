import { StringDictionary } from './Dictionary';

export function toQueryParamsString(params: StringDictionary, prefix: string = '?') {
  return prefix + Object.keys(params).map(key => `${key}=${params[key]}`).join('&');
}
