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

  /**
   * Slug generator
   * @param input
   */
  public slugGenerator(input) {
        return input.toString().toLowerCase()
            .replace(/\s+/g, '-')
            .replace(/[^\w\-]+/g, '')
            .replace(/\-\-+/g, '-')
            .replace(/^-+/, '')
            .replace(/-+$/, '');
  }

  /**
   * Value of enumerator
   * @param values
   * @param key
   */
  public valueOfEnumerator(values, key) {
    for(let o of  values) {
        if (o.key == key) {
            return o.value;
        }
    }

    return '-';
  }

}
