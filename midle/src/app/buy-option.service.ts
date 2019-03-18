import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Configuration, Utils} from './app.constants';

/**
 * Buy option service
 */
@Injectable({
  providedIn: 'root'
})

/**
 * Buy option service
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
export class BuyOptionService {

  /**
   * Server URL
   */
  private actionUrl: string;

  /**
   * Default constructor
   * @param http client injection
   */
  constructor(private http: HttpClient, private _utils: Utils, private _configuration: Configuration) {
    this.actionUrl = _configuration.server;
    let headers = this._utils.getHeaders();
  }

  /**
   * Get all buy options
   * @return list of buy option
   */
  public getAll<T>(): Observable<T> {
    return this.http.get<T>(this.actionUrl.concat('/buy-option'));
  }

  /**
   * Add buy option
   * @param buy option
   */
  public add<T>(id: string, item: Object ): Observable<T> {
    return this.http.post<T>( this.actionUrl.concat('/buy-option/add/deal/').concat(id), item);
  }

  /**
   * Update buy option
   * @param duy option
   */
  public update<T>( item: Object ): Observable<T> {
    return this.http.put<T>( this.actionUrl.concat('/buy-option/update'), item);
  }

  /**
   * Decrement quantity
   * @param id of buy option
   */
  public decrementQuantity<T>( id: string ): Observable<T> {
    return this.http.put<T>( this.actionUrl.concat('/buy-option/decrement/').concat(id), {});
  }

  /**
   * Delete buy option
   * @param id of buy option
   */
  public delete<T>( id: string ): Observable<T> {
    return this.http.delete<T>( this.actionUrl.concat('/buy-option/').concat(id));
  }

}
