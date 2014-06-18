class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        l = list()
        operators = ['+', '-', '*', '/']
        for token in tokens:
            if token not in operators:
                l.append(token)
            else:
                right_operand = int(l.pop())
                left_operand = int(l.pop())
                if token == '+':
                    result = left_operand + right_operand
                elif token == '-':
                    result = left_operand - right_operand
                elif token == '*':
                    result = left_operand * right_operand
                else:
                    result = int(left_operand / float(right_operand))
                l.append(str(result))
        return int(l.pop())
