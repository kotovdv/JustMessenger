import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {HttpModule} from "@angular/http";
import {FormComponent} from "./components/just-messenger/form/form.component";

@NgModule({
    imports: [BrowserModule, HttpModule],
    declarations: [AppComponent, FormComponent],
    bootstrap: [AppComponent],
})
export class AppModule {
}