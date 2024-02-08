#for loop,current_element,next_element,for loop,result 
def generate_permutations(input_sequence):
    if len(input_sequence) == 1:
        return [input_sequence]
    result = []
    for i in range(len(input_sequence)):
        current_digit = input_sequence[i]
        remaining_digits = input_sequence[:i] + input_sequence[i+1:]
        for perm in generate_permutations(remaining_digits):
            result.append(current_digit + perm)
    return result
user_input = input("Enter a sequence of digits: ")
if user_input.isdigit():
    input_sequence = user_input
    permutations_list = generate_permutations(input_sequence)
    for perm in permutations_list:
        print(perm)
else:
    print("Invalid")
