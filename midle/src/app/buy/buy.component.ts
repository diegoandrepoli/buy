import { Component, OnInit } from '@angular/core';
import {DealService} from '../deal.service';
import {BuyOptionService} from '../buy-option.service';
import {ActivatedRoute} from '@angular/router';

/**
 * Custom component options
 * @see custom boostrap popover to sizing
 */
@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css'],
  styles: [`
        :host >>> .popover {
          color: #000;
          max-width: 100%;
        }
    `]
})

/**
 * Product page component (buy)
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
export class BuyComponent implements OnInit {

  /**
   * Deal object
   */
  deal: Object[];

  /**
   * Custom component constructor
   * @param route as activated route
   * @param _deal as deal service
   * @param _buyOption as buy option service
   */
  constructor(private route: ActivatedRoute, private _deal: DealService, private _buyOption: BuyOptionService) { }

  /**
   * Init componentss
   */
  ngOnInit() {
    this.getDealByUrl(this.getUrl());
  }

  /**
   * Get component URL
   */
  getUrl(){
    return this.route.snapshot.paramMap.get('url');
  }

  /**
   * Get deal by url
   * @param id
   */
  getDealByUrl(id) {
    this._deal.getByUrl<Object[]>(id).subscribe((data: Object[]) => this.deal = data);
  }

  /**
   * Sale buy option
   * @param dealId
   * @param buyOptionId
   */
  saleBuyOption(dealId, buyOptionId) {
    this._deal.buy<Object[]>(dealId, buyOptionId).subscribe((data: Object[]) => {
      alert("Parabéns! Sua compra foi concluída!");
    });
  }


}
