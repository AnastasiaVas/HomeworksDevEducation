/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var property = new Array();
var unit = new Array();
var factor = new Array();

property[0] = "Time";
unit[0] = new Array("Seconds", "Minutes", "Hours", "Days", "Weeks", "Months", "Astronomical Years");
factor[0] = new Array(1, 0.0166667, 0.000277778, 0.0000115741, 1.6534E-6, 3.80517e-7, 31557600);

property[1] = "Weight";
unit[1] = new Array("Kilogram", "Gram", "Carat", "Engligh Pounds", "Pounds", "Stone", "Russian Pounds");
factor[1] = new Array(1, 1000, 5000, 0.3048, 0.3048, 3.28084, 0.157473);

property[2] = "Volume";
unit[2] = new Array("Litre", "Cubic Metre", "Gallon", "Pint", "Quart", "Barrel", "Cubic Foot", "Cubic Inch");
factor[2] = new Array(1, 0.001, 0.264172, 2.11338, 1.05669, 0.00628981, 0.0353147, 61.0237);

property[3] = "Length";
unit[3] = new Array("Meters", "Kilometers", "Miles", "Nautical Miles", "Cables", "Leagues", "Feet", "Yards");
factor[3] = new Array(1, 1000, 0.000621371, 0.000539957, 0.054, 0.0002071237, 3.28084, 1.09361);

property[4] = "Temperature";
unit[4] = new Array("Celsius Scale", "Fahrenheit Scale", "Kelvin Scale", "Rankin Scale", "Réaumur Scale", "Remer Scale", "Newtone Scale", "Delisle Scale");
factor[4] = new Array(1, 0.555555555555, 1, 0.555555555555);
tempIncrement = new Array(0, -32, -273.15, -491.67);

function ChangeUnits(propMenu, unitMenu)
{
  var i;
  i = propMenu.selectedIndex;
  FillMenuWithArray(unitMenu, unit[i]);
}

function FillMenuWithArray(myMenu, myArray) {
  var i;
  myMenu.length = myArray.length;
  for (i = 0; i < myArray.length; i++) {
    myMenu.options[i].text = myArray[i];
  }
}

function CalculateUnit(sourceForm, targetForm) {

  var sourceValue = sourceForm.value_input.value;
  sourceValue = parseFloat(sourceValue);
  if (!isNaN(sourceValue) || sourceValue == 0) {
    sourceForm.value_input.value = sourceValue;
    ConvertFromTo(sourceForm, targetForm);
  }
}

function ConvertFromTo(sourceForm, targetForm) {
  var propIndex;
  var sourceIndex;
  var sourceFactor;
  var targetIndex;
  var targetFactor;
  var result;

  propIndex = document.general_form.units.selectedIndex;

  sourceIndex = sourceForm.unit_menu.selectedIndex;
  sourceFactor = factor[propIndex][sourceIndex];

  targetIndex = targetForm.unit_menu.selectedIndex;
  targetFactor = factor[propIndex][targetIndex];


  result = sourceForm.value_input.value;
  if (property[propIndex] == "Temperature") {
    result = parseFloat(result) + tempIncrement[sourceIndex];
  }
  result = result * targetFactor;

  result = result / sourceFactor;

  if (property[propIndex] == "Temperature") {
    result = parseFloat(result) - tempIncrement[targetIndex];
  }

  // Ta-da! All that's left is to update the target input box:
  targetForm.value_input.value = result;
}

window.onload = function(e) {
  FillMenuWithArray(document.general_form.units, property);
  ChangeUnits(document.general_form.units, document.form_A.unit_menu);
  ChangeUnits(document.general_form.units, document.form_B.unit_menu);
};