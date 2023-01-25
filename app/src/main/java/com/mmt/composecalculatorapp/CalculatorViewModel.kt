package com.mmt.composecalculatorapp

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorActions) {
        when(action) {
            is CalculatorActions.Number -> enterNumber(action.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(action.operation)
            is CalculatorActions.Calculate -> performCalculate()
            is CalculatorActions.Delete -> performDeletion()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(number2 = state.number2 + number)
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")
            return
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Multiply -> number1 * number2
                else -> null
            }
            if (result != null) {
                state = CalculatorState(number1 = result.toString())
            }
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}