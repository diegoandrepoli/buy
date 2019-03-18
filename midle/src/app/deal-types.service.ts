import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import { Configuration, Utils } from './app.constants';

@Injectable({
  providedIn: 'root'
})

/**
 * Deal type service
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
export class DealTypesService {

  /**
   * Server URL
   */
  private actionUrl: string;

  /**
   * Custom service constructor
   * @param http
   */
  constructor(private http: HttpClient, private _utils: Utils, private _configuration: Configuration) {
    this.actionUrl = _configuration.server;
    let headers = this._utils.getHeaders();
  }

  /**
   * Get all types
   */
  public getAll<T>(): Observable<T> {
    return this.http.get<T>(this.actionUrl.concat('/type'));
  }

}
