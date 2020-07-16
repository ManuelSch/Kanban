import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BoardComponent } from './components/board/board.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full'},
  { path: ':boardId', component: BoardComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
