import { Injectable } from '@angular/core';
import {HttpClientModule, HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';

/**
 * Application service configuration
 */
@Injectable()
export class Configuration {
    public server = 'http://localhost:8081';
}

/**
 * Aplications utils
 */
@Injectable()
export class Utils {

  /**
   * Get http headers
   */
  public getHeaders() {
    return new HttpHeaders().set('Content-Type', 'application/json');
  }


}
