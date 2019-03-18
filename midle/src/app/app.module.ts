import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DealComponent } from './deal/deal.component';
import { DealService } from './deal.service';
import { DealTypesService } from './deal-types.service';
import { BuyOptionService } from './buy-option.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BuyOptionComponent } from './buy-option/buy-option.component';
import { BuyComponent } from './buy/buy.component';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxMaskModule } from 'ngx-mask';
import { Configuration, Utils } from './app.constants';

@NgModule({
  declarations: [
    AppComponent,
    DealComponent,
    BuyOptionComponent,
    BuyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    TooltipModule,
    NgbModule,
    NgxMaskModule.forRoot()
  ],
  providers: [
    DealService,
    BuyOptionService,
    DealTypesService,
    Configuration,
    Utils
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
