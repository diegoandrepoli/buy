import { Component, OnInit, HostListener } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';
import { DealTypesService } from '../deal-types.service';
import { DealService } from '../deal.service';
import { Utils } from '../app.constants';

@Component({
  selector: 'app-deal',
  templateUrl: './deal.component.html',
  styleUrls: ['./deal.component.css']
})

/**
 * Deal component
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
export class DealComponent implements OnInit {

  /**
   * Is showing form editor
   */
  isUserEditor = false;

  /**
   * List of deals
   */
  deals: Object[];

  /**
   * List of deal types
   */
  dealsTypes: Object[];

  /**
   * Deal form mapping
   */
  dealForm = this.fb.group({
    id: null,
    title: ['', Validators.required],
    text: ['', Validators.required],
    createDate: [{ value: '', disabled: true, }],
    publishDate: ['', Validators.required],
    endDate: ['', Validators.required],
    url: ['', Validators.required],
    totalSold: ['', Validators.required],
    type: ['', Validators.required],

  },{});

  /**
   * Component constructor
   * @param fb as form builder
   * @param _deal as deal service
   * @param _dealTypes as deal type service
   */
  constructor(private fb: FormBuilder, private _deal: DealService, private _dealTypes: DealTypesService, private utils: Utils) {}

  /**
   * On init component
   */
  ngOnInit() {
    this.getAll();
    this.getTypes();
  }

  /**
   * Get all deals
   */
  getAll() {
    this._deal.getAll<Object[]>().subscribe((data: Object[]) => this.deals = data);
  }

  /**
   * Get deal types
   */
  getTypes() {
    this._dealTypes.getAll<Object[]>().subscribe((data: Object[]) => this.dealsTypes = data);
  }

  /**
   * Generate date object
   * @param date as string
   * @return date as date object
   */
  generateDateType(date) {
    return new Date(date).toISOString().split('T')[0];
  }

  /**
   * Delete user
   * @param content
   * @param item
   */
  deleteUser(content, item) {
    //patch form
    this.dealForm.patchValue(item);

    //delete deal
    this._deal.delete(this.dealForm.value.id).subscribe(res => { this.getAll() });
  }


  formSerialize(form) {
    form.createDate = this.generateDateType(form.createDate);
    form.publishDate = this.generateDateType(form.publishDate);
    form.endDate = this.generateDateType(form.endDate);

    return form;
  }

  /**
   * Submit form value
   */
  onSubmit() {

    //perform date
    this.dealForm.value.createDate = this.utils.getNewDate();

    //populate total sold
    this.setInitialTotalSold();

    //patch date values as object
    this.dealForm.patchValue(this.formSerialize(this.dealForm.value));

    //save deal
    this._deal.add(this.dealForm.value).subscribe(res => { this.getAll() });

    //disable modal
    this.isUserEditor = false;

    //clear form
    this.dealForm.reset();
  }

  /**
   * Update deal
   * @param deal form values
   */
  update(deal) {
    //path form dates
    this.dealForm.patchValue(this.formSerialize(deal));

    //disable editor
    this.isUserEditor = true;
  }

  asType(key) {
    return this.utils.valueOfEnumerator(this.dealsTypes, key);
  }

  /**
   * Populate total sold
   */
  setInitialTotalSold(){
    if(this.dealForm.value.totalSold === ''){ this.dealForm.value.totalSold = 0; }
  }

  /**
   * Slug generator
   */
  generateUrl() {
      this.dealForm.controls['url'].setValue(this.utils.slugGenerator(this.dealForm.value.title));
  }

}
