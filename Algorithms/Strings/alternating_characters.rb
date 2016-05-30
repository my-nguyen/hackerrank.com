def alternating_characters(string)
  # left index operates from the beginning of string
  left = 0
  count = 0
  while true
    # right index operates from the right of left index and keeps looking for
    # and deleting characters in sequence that match that at left index
    right = left+1
    while (right < string.length) && (string[left] == string[right])
      string.slice!(right)
      count += 1
    end

    # exit scenario when left is at the end of string
    if left == string.length-1
      break
    else
      left += 1
    end
  end
  return count
end


gets.to_i.times do
  puts(alternating_characters(gets.strip))
end
