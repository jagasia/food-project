import { Component, DoCheck, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit, OnChanges, DoCheck {
  foodForm:any;
  file:File;
  foods:any;
  constructor(private fb:FormBuilder, private fs:FoodService) {
    this.foodForm=this.fb.group({
      id:[''],
      name:[''],
      expiryDate:[''],
      picture:['']
    });
    
   }
  ngOnChanges(changes: SimpleChanges): void {
    
  }
  ngDoCheck(): void {

  }

  ngOnInit(): void {
    this.fs.getAllFoods().subscribe(data=>this.foods=data);
  }

  fnChange(event)
  {
    this.file=event.target.files[0];
    console.log(this.file.name);
    console.log(this.file.size);
  }

  fnAdd()
  {
    var fd=new FormData();
    // alert(this.foodForm.controls['expiryDate'].value);
    fd.append("id",this.foodForm.controls['id'].value);
    fd.append("name",this.foodForm.controls['name'].value);
    fd.append("expiryDate",this.foodForm.controls['expiryDate'].value);
    fd.append("picture",this.file,this.file.name);

    this.fs.addFood(fd).subscribe(data=>console.log(data));
    
  }
}
