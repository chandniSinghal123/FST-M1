import pytest
def test_sumOfTwoNumbers():
    input1 = 15
    input2 = 5
    sum=input1+input2
    assert sum == 20
def test_diffOfTwoNumbers():
    input1 = 10
    input2 = 5
    diff=input1-input2
    assert diff == 5

def test_productOfTwoNumbers():
    input1 = 15
    input2 = 5
    product=input1*input2
    assert product == 75

def test_divisonOfTwoNumbers():
    input1 = 15
    input2 = 5
    division=input1/input2
    assert division == 3