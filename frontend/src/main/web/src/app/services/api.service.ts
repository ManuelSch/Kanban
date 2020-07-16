import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { StringDictionary } from '../util/Dictionary';
import { toQueryParamsString } from '../util/toQueryParamsString';

export interface SuccessResponse<T> {
  data: T;
}

export interface ErrorResponse {
  error: true;
  errorMsg: string;
}

export type ApiResponse<T> = SuccessResponse<T> | ErrorResponse;

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  apiUrl: String = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  public async get<RES>(url: string, queryParams: StringDictionary = {}): Promise<RES> {
    const params = toQueryParamsString(queryParams);
    const res = await this.http.get<ApiResponse<RES>>(this.apiUrl + url + params).toPromise();
    return this.handleResponse(res);
  }

  public async post<RES>(url: string, body: any | null): Promise<RES> {
    const res = await this.http.post<ApiResponse<RES>>(this.apiUrl + url, body).toPromise();
    return this.handleResponse(res);
  }

  private handleResponse<RES>(res: ApiResponse<RES>): RES {
    if('error' in res && res.error && res.errorMsg) {
      throw res.errorMsg;
    }
    else if ('data' in res && res.data) {
      return res.data;
    }
  }

}
