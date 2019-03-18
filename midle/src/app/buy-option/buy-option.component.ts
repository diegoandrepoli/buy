import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {FormBuilder, Validators} from "@angular/forms";
import { BuyOptionService } from '../buy-option.service';
import {DealService} from "../deal.service";
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';

/**
 * Component configuration (default angular)
 */
@Component({
  selector: 'app-buy-option',
  templateUrl: './buy-option.component.html',
  styleUrls: ['./buy-option.component.css']
})

/**
 * Buy option component
 */
export class BuyOptionComponent implements OnInit {

  /**
   * Custom constructor component
   * @param fb as form builder
   * @param route as  angular active route
   * @param _buyOption as buy option service
   * @param _deal as deal service
   */
  constructor(private fb: FormBuilder, private route: ActivatedRoute, private _buyOption: BuyOptionService, private _deal: DealService) {}

  /**
   * Is use editor control
   */
  isUserEditor = false;

  /**
   * Select levels object
   */
  selectedLevel: Object[];

  /**
   * Buy form builder
   */
  buyOptionForm = this.fb.group({
    id: null,
    deal: ['', Validators.required],
    title: ['', Validators.required],
    normalPrice: ['', Validators.required],
    salePrice: ['', Validators.required],
    percentageDiscount: ['', Validators.required],
    quantityCupom: ['', Validators.required],
    startDate: ['', Validators.required],
    endDate: ['', Validators.required]

  }, {});

  /**
   * Init component
   */
  ngOnInit() {
    this.getDeal();
  }

  /**
   * Get deal id (get url deal id)
   */
  getDealId() {
    return this.route.snapshot.paramMap.get('dealId');
  }

  /**
   * Get deal
   */
  getDeal() {
    this.getDealById(this.getDealId());
  }

  /**
   * Get deal lby id
   * @param id od deal
   */
  getDealById(id) {
    this._deal.getById<Object[]>(id).subscribe((data: Object[]) => { this.selectedLevel = data });
  }

  /**
   * Serialize form
   * @param form builder
   */
  formSerialize(form) {
    form.startDate = new Date(form.startDate).toISOString().split('T')[0];
    form.endDate = new Date(form.endDate).toISOString().split('T')[0];
    return form;
  }

  /**
   * Update buy option
   * @param form as values
   */
  updateBuyOption(form) {
    this._buyOption.update(form).subscribe(res => { this.getDeal(); });
  }

  /**
   * Save buy option
   * @param deal id
   * @param form as values
   */
  saveBuyOption(dealId, form) {
    this._buyOption.add(dealId, form).subscribe(res => { this.getDeal(); });
  }

  /**
   * Submit form
   */
  onSubmit() {
      //add select level
      this.buyOptionForm.value.deal = this.selectedLevel;

      //patch values of form
      this.buyOptionForm.patchValue(this.formSerialize(this.buyOptionForm.value));

      //edit or update form
      if(this.buyOptionForm.value.id) {
        this.updateBuyOption(this.buyOptionForm.value);
      }else{
        this.saveBuyOption(this.getDealId(), this.buyOptionForm.value);
      }

      //dispose modal
      this.isUserEditor = false;
  }

  /**
   * Update buy option
   * @param buy option
   */
  update(deal) {
    //set buy option to edit
    this.buyOptionForm.patchValue(this.formSerialize(deal));

    //set to open editor
    this.isUserEditor = true;
  }

  /**
   * Delete buy option
   * @param content
   * @param item as delete
   */
  deleteUser(content, item) {
    //patch form values
    this.buyOptionForm.patchValue(item);

    //delete buy option
    this._buyOption.delete(this.buyOptionForm.value.id).subscribe(res => {  this.getDeal(); });
  }

}
