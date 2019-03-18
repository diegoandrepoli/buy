import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Configuration, Utils } from './app.constants';


/**
 * Deal service
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Injectable()
export class DealService {

  /**
   * Server URL
   */
  private actionUrl: string;

  /**
   * Custom construcotor
   * @param http
   */
  constructor(private http: HttpClient, private _utils: Utils, private _configuration: Configuration) {
    this.actionUrl = _configuration.server;
    let headers = this._utils.getHeaders();
  }

  /**
   * Get all deals
   * @return list of deals
   */
  public getAll<T>(): Observable<T> {
      return this.http.get<T>(this.actionUrl.concat('/deal'));
  }

  /**
   * Add deal
   * @param deal
   */
  public add<T>( item: Object ): Observable<T> {
      return this.http.post<T>( this.actionUrl.concat('/deal/add'), item);
  }

  /**
   * Update deal
   * @param deal
   */
  public update<T>( item: Object ): Observable<T> {
    return this.http.put<T>( this.actionUrl.concat('/deal'), item);
  }

  /**
   * Delete deal
   * @param id of deal
   */
  public delete<T>( id: string ): Observable<T> {
    return this.http.delete<T>( this.actionUrl.concat('/deal/').concat(id));
  }

  /**
   * Get by id
   * @param id of deal
   */
  public getById<T>( id: string ): Observable<T> {
    return this.http.get<T>( this.actionUrl.concat('/deal/').concat(id));
  }

  /**
   * Get by url
   * @param url as deal
   */
  public getByUrl<T>( url: string ): Observable<T> {
    return this.http.get<T>( this.actionUrl.concat('/deal/url/').concat(url));
  }

  /**
   * Byu!
   * @param deal id
   * @param buy option id
   */
  public buy<T>( dealId: string, buyOptionId: string): Observable<T> {
    return this.http.put<T>( this.actionUrl.concat('/deal/').concat(dealId).concat('/decrement/buy-option/').concat(buyOptionId), {});
  }

}
