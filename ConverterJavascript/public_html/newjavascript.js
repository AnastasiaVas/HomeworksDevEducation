/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var property = new Array();
var unit = new Array();
var factor = new Array();

property[0] = "Time";
unit[0] = new Array("Minutes", "Hours", "Days", "Weeks", "Months", "Astronomical Years");
factor[0] = new Array(1, .3048, 9.806650, .01, 2.54E-02);

property[1] = "Weight";
unit[1] = new Array("Gram", "Carat", "Engligh Pounds", "Pounds", "Stone", "Russian Pounds");
factor[1] = new Array(1, 4046.856, 100, 1E-28, 10000, 1011.71413184285, .0001, 1000000, 5.067075E-10, 9.290304E-02, 6.4516E-04, 2589988, .8361274);

property[2] = "Volume";
unit[2] = new Array("Cubic Metre", "Gallon", "Pint", "Quart", "Barrel", "Cubic Foot", "Cubic Inch");
factor[2] = new Array(1, .0000001, 9.806650, .1129848, 1.355818);

property[3] = "Length";
unit[3] = new Array("Kilometers", "Miles", "Nautical Miles", "Cables", "Leagues", "Feet", "Yards");
factor[3] = new Array(1, 10, 3600, 96521.8999999997, .000000000333564, 96.5219, 9.65219E-02, 9.65219E-05);

property[4] = "Temperature";
unit[4] = new Array("Kelvin Scale", "Fahrenheit Scale", "Réaumur Scale", "Remer Scale", "Rankin Scale", "Newtone Scale", "Delisle Scale");
factor[4] = new Array(1, 1055.87, 1054.35, 4.1868, 4.19002, 4.184, 1.6021E-19, .0000001, 1.355818, 4.214011E-02, 2684077.3, 4186.8, 4190.02, 3600000, 4.2E9, 1, 3600, 1);

function ChangeUnits(propMenu, unitMenu)
{
  var i;
  i = propMenu.selectedIndex;
  FillMenuWithArray(unitMenu, unit[i]);
}

function FillMenuWithArray(myMenu, myArray) {
  // Fills the options of myMenu with the elements of myArray.
  // !CAUTION!: It replaces the elements, so old ones will be deleted.
  var i;
  myMenu.length = myArray.length;
  for (i = 0; i < myArray.length; i++) {
    myMenu.options[i].text = myArray[i];
  }
}

window.onload = function(e) {
  FillMenuWithArray(document.general_form.units, property);
  ChangeUnits(document.general_form.units, document.form_A.unit_menu);
  ChangeUnits(document.general_form.units, document.form_B.unit_menu);
};