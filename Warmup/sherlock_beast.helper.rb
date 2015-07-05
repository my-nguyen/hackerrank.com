string = gets
three = string.index('3')
if three == nil
  three = 0
end
puts("fives: #{three}, threes: #{string.length-three}")
