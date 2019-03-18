import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DealComponent } from './deal/deal.component';
import { BuyOptionComponent } from './buy-option/buy-option.component';
import { BuyComponent } from './buy/buy.component';

const routes: Routes = [
  {
    path: 'deal',
    component: DealComponent
  },
  {
    path: 'buy-option/:dealId',
    component: BuyOptionComponent
  },
  {
    path: 'buy/:url',
    component: BuyComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
