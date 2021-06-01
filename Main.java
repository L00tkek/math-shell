public class Main
{
    public static String[] parseExpression(String expression)
    {		
        boolean hasOp = false;

        if(expression.charAt(expression.length() - 1) != ' ')
        {
            //avoid hanging numbers at the end by adding a space if there is not already one
            expression += ' ';
        }

        ArrayList<String> list = new ArrayList<String>();

        int beg = 0; //keeps track of the beginning of each element

        for(int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);

            //2 cases for dividing points: operators, which we want to preserve, and spaces,
            //which we want to skip. 
            if(ch == ' ')
            {
                if(beg == i)
                {
                    //if we are not currently tracking some element, we have no use for
                    //a space, so we just skip it
                    beg++;
                }
                else
                {
                    //if we are tracking some other element, this space signifies the end
                    //of that element, so we can add it and skip the space
                    list.add(expression.substring(beg, i));
                    beg = i + 1;
                }
            }
            else if(precedence(ch) != -1) //it is a non-space operator
            {
                if(beg == i)
                {
                    //if we are not currently tracking some other element, then
                    //add the operator and move on
                    list.add(expression.substring(beg, i + 1));
                    beg++;
                }
                else
                {
                    //if we are currently tracking some other element, then
                    //add both the operator and the element we were tracking
                    list.add(expression.substring(beg, i));
                    list.add(ch + "");
                    beg = i + 1;
                }
                hasOp = true;
            }
        }

        //if the list is not just a single number (which would be a valid expression),
        //then it needs to have at least one operator in it to be valid. otherwise,
        //we throw an exception.
        if(!hasOp && list.size() != 1) 
        {
            throw new IllegalArgumentException("no operator, can't evaluate");
        }

        return list.toArray(new String[0]); //return the list as an array of Strings
    }
}

static int precedence(char op)
{
    switch(op)
    {
        case '(': case ')':
            return 7;
        case '^':
            return 6;
        case '%':
            return 5;
        case '*': case '/':
            return 4;
        case '+': case '-':
            return 3;
        case '<': case '>':
            return 2;
        case '=':
            return 1;
        case ' ':
            return 0;
        default: //all non-operator characters return -1
            return -1;
    }
}
