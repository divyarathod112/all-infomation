import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrisisListComponentComponent } from './crisis-list-component/crisis-list-component.component';

const routes: Routes = [{
  path: 'mummy', component: CrisisListComponentComponent 
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }