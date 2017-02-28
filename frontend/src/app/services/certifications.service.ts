import { Injectable, EventEmitter } from '@angular/core';
import {Certification} from "../model/certification";

@Injectable()
export class CertificationsService {
  private _certificationEmmiter: EventEmitter<Certification> = new EventEmitter();

  constructor() { }

  get certificationEmmiter(): EventEmitter<Certification> {
    return this._certificationEmmiter;
  }
}
