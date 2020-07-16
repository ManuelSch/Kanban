import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  apiUrl: String = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  public async get(url: string): Promise<Object> {
    return this.http.get(this.apiUrl + url).toPromise();
  }

  public async post(url: string, body: any | null): Promise<Object> {
    return this.http.post(this.apiUrl + url, body).toPromise();
  }

}
