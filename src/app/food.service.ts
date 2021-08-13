import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  url:string='http://localhost:5000/food';
  constructor(private http:HttpClient) { }

  getAllFoods()
  {
    return this.http.get(this.url);
  }
  findFoodById(id:any)
  {
    return this.http.get(this.url+"/"+id);
  }
  addFood(food:any) //this is not object of food. this is object of form data
  {
    return this.http.post(this.url,food);
  }
  modifyFood(food:any)
  {
    return this.http.put(this.url,food);
  }
  removeFood(id:any)
  {
    return this.http.delete(this.url+"/"+id);
  }
}
